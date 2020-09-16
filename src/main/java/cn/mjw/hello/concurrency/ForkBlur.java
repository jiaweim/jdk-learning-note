package cn.mjw.hello.concurrency;

import java.util.concurrent.RecursiveAction;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 06 Mar 2020, 10:04 AM
 */
public class ForkBlur extends RecursiveAction
{
    private int[] source;
    private int start;
    private int length;
    private int[] destination;

    // processing window size, should be odd
    private int blueWidth = 15;

    public ForkBlur(int[] source, int start, int length, int[] destination)
    {
        this.source = source;
        this.start = start;
        this.length = length;
        this.destination = destination;
    }

    protected void computeDirectly()
    {
        int sidePixels = (blueWidth - 1) / 2;
        for (int index = start; index < start + length; index++) {
            // calculate average
            float rt = 0, gt = 0, bt = 0;
            for (int mi = -sidePixels; mi <= sidePixels; mi++) {
                int mindex = Math.min(Math.max(mi + index, 0), source.length - 1);
                int pixel = source[mindex];
                rt += (float) ((pixel & 0x00ff0000) >> 16) / blueWidth;
                gt += (float) ((pixel & 0x0000ff00) >> 8) / blueWidth;
                bt += (float) ((pixel & 0x000000ff) >> 0) / blueWidth;
            }

            // Reassemble destination pixel.
            int dpixel = (0xff000000) |
                    (((int) rt) << 16) |
                    (((int) gt) << 8) |
                    (((int) bt) << 0);
            destination[index] = dpixel;
        }
    }

    protected static int sThreshold = 100000;

    @Override
    protected void compute()
    {
        if (length < sThreshold) {
            computeDirectly();
            return;
        }

        int split = length / 2;

        invokeAll(new ForkBlur(source, start, split, destination),
                new ForkBlur(source, start + split, length - split,
                        destination));
    }
}
