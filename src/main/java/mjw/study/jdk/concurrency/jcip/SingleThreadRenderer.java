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

/**
 * 实现浏览器程序中的 页面渲染功能，即将 HTML 页面绘制到图形缓存中。
 * <p>
 * 串行的页面渲染：
 * 先绘制文本元素，同时为图形预留出矩形的占位空间，在处理完第一遍文本后，程序再下载图像，并将它们
 * 绘制到相应的占位空间中。
 * <p>
 * 图像下载过程的大部分时间都是在等待I/O操作执行完成，在这期间CPU几乎不做任何工作。因此，这种串行执行
 * 方法没有充分利用CPU，使得用户在看到最终页面之前要等待过长的时间。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2019, 4:25 PM
 */
public abstract class SingleThreadRenderer
{
    void renderPage(CharSequence source)
    {
        renderText(source);
        List<ImageData> imageData = new ArrayList<>();
        for (ImageInfo imageInfo : scanForImageInfo(source))
            imageData.add(imageInfo.downloadImage());
        for (ImageData data : imageData)
            renderImage(data);

    }

    interface ImageData
    {
    }

    interface ImageInfo
    {
        ImageData downloadImage();
    }

    abstract void renderText(CharSequence s);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData i);
}
