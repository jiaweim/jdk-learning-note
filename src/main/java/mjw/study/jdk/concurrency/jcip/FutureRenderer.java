/*
 * Copyright 2018 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mjw.study.jdk.concurrency.jcip;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 为了使页面渲染实现更高的并发性，首先将渲染的过程分解为两个任务: 渲染文本和下载图像。
 * <p>
 * Callable 和 Future 有助于表示这些协同任务之间的交互。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2019, 4:40 PM
 */
public abstract class FutureRenderer {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    void renderPage(CharSequence source) {
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        Callable<List<ImageData>> task = () -> { // IO 密集
            List<ImageData> result = new ArrayList<>();
            for (ImageInfo imageInfo : imageInfos)
                result.add(imageInfo.downloadImage());
            return result;
        };

        Future<List<ImageData>> future = executor.submit(task);
        renderText(source); // CPU 密集

        try {
            List<ImageData> imageData = future.get();
            for (ImageData data : imageData) {
                renderImage(data);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            future.cancel(true);
        } catch (ExecutionException e) {
            throw LaunderThrowable.launderThrowable(e.getCause());
        }


    }

    interface ImageData {
    }

    interface ImageInfo {
        ImageData downloadImage();
    }

    abstract void renderText(CharSequence s);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData i);
}
