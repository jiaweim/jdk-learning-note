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

package cn.mjw.hello.concurrency.jcip;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2019, 4:56 PM
 */
public abstract class Renderer
{
    private final ExecutorService executor;

    public Renderer(ExecutorService executor)
    {
        this.executor = executor;
    }

    void renderPage(CharSequence source)
    {
        final List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<>(executor);
        for(final  ImageInfo imageInfo : info){
            completionService.submit(new Callable<ImageData>()
            {
                @Override public ImageData call() throws Exception
                {
                    return imageInfo.downloadImage();
                }
            });
        }

        renderText(source);

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
