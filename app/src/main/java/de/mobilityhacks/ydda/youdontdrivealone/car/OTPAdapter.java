package de.mobilityhacks.ydda.youdontdrivealone.car;

public class OTPAdapter
{
    private static final String IP = "http://192.168.189.99:9080/";
    public static final String TAG = OTPAdapter.class.getName();

    public short getShortProperty(String field, short value) {
//        URL url = new URL(IP + "vehicle?fields=" + field);
//        Log.d(TAG, "Try to get response from " + url.toString());

//              Normally we would send a HTTP-request, but OTP-Server sends
        //      responses without HTTP-statusline, so we can not work with it (confirmed bug)
        //      and we had to hardcode values via value parameter
//            OkHttpClient client = new OkHttpClient.Builder().
//                    connectTimeout(1, TimeUnit.SECONDS).
//                    readTimeout(2, TimeUnit.SECONDS).
//                    writeTimeout(2, TimeUnit.SECONDS).
//                    build();
//
//            Request request = new Request.Builder()
//                    .url(url)
//                    .addHeader("Connection", "keep-alive")
//                    .addHeader("Accept", "*/*")
//                    .addHeader("Accept-Encoding", "gzip, deflate, sdch")
//                    .addHeader("Accept-Language", "en-US,en;q=0.8")
//                    .addHeader("Referer", "http://192.168.189.99:9080/vehicle?fields=rpm")
//                    .build();
//
//            Response response = client.newCall(request).execute();
//            Log.d(TAG, response.body().toString());
//        } catch (Exception e) {
//            Log.e(TAG, e.toString());
        return value;
    }

    public byte getByteProperty(byte value) {
        //Hardcoded value (same as short value)
        return value;
    }
}
