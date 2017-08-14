package www.pdx.life.ykmtools.tools;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wenxin on 2016/1/14.
 * 邮箱：kongming.yang@pdxchg.com
 */

/**
 * 图片管理类
 */
public class BitmapUtils {

    /**
     * 保存图片到sd卡中
     *
     * @param bitmap
     * @param filePath
     * @param fileName
     * @return
     */
    public static boolean saveBitmapToSDCard(Bitmap bitmap, String filePath,
                                             String fileName) {
        boolean flag = false;
        if (null != bitmap) {
            try {
                fileName = fileName + ".jpg";
                File file = new File(filePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File f = new File(filePath + fileName);
                if (f.exists()) {
                    f.delete();
                }
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream(f));
                bitmap.compress(CompressFormat.JPEG, 100, outputStream);
                outputStream.flush();
                outputStream.close();
                flag = true;
            } catch (IOException e) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 图片转换
     *
     * @param drawable
     * @return bitmap
     */
    public static Bitmap drawableToBitmap2(Drawable drawable) {
        BitmapDrawable bd = (BitmapDrawable) drawable;
        return bd.getBitmap();
    }

    /**
     * 图片转换
     *
     * @param bitmap
     * @return
     */
    public static Drawable bitmapTodrawable(Bitmap bitmap) {
        Drawable drawable = new BitmapDrawable(bitmap);
        drawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        return drawable;
    }

    /**
     * 图片转换
     *
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable drawable) {
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Config.ARGB_4444
                : Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 圆角图片生成器
     *
     * @param bitmap
     * @param pixels
     * @return
     */
    public static Bitmap toRoundCorner(Bitmap bitmap, int pixels) {

        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Config.ARGB_4444);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, pixels, pixels, paint);

        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    //压缩图片大小
    public static Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(CompressFormat.JPEG, 100, baos);
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100 && options > 0) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();
            image.compress(CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        return BitmapFactory.decodeStream(isBm, null, null);
    }


    /**
     * @param resources
     * @param resId
     * @param width
     * @param height
     * @return
     */
    public static Bitmap decodeSampledBitmapFromResource(Resources resources,
                                                         int resId, int width, int height) {
        // 给定的BitmapFactory设置解码的参数
        BitmapFactory.Options options = new BitmapFactory.Options();
        // 从解码器中获得原始图片的宽高，而避免申请内存空间
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resId, options);
        options.inSampleSize = calculateInSampleSize(options, width, height);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, resId, options);
    }

    /**
     * 指定输出图片的缩放比例
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // 获得原始图片的宽高
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        int inSimpleSize = 1;
        if (imageHeight > reqHeight || imageWidth > reqWidth) {

            // 计算压缩的比例：分为宽高比例
            final int heightRatio = Math.round((float) imageHeight
                    / (float) reqHeight);
            final int widthRatio = Math.round((float) imageWidth
                    / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will
            // guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSimpleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSimpleSize;
    }

}