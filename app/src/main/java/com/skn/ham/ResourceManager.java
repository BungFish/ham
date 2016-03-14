package com.skn.ham;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ResourceManager {

    private static final String LOG_TAG = ResourceManager.class.getSimpleName();
    private static final String TEST_FILE_NAME = "markup-guide-master";
    private static final String FILE_NAME = "app";
    private static final String ZIP_FILE_NAME = FILE_NAME + ".zip";
    private static final String DOWNLOAD_URL = "https://github.com/teamslogup/markup-guide/archive/master.zip";

    private Context mContext;
    private DownloadCallBack mDownloadCallBack;

    public ResourceManager(Context context) {

        this.mContext = context;
    }

    public ResourceManager setDownloadCallBack(DownloadCallBack downloadCallBack) {

        mDownloadCallBack = downloadCallBack;
        return this;
    }

    public static boolean hasResource(Context context) {

        String unzipFilePath = context.getFilesDir() + File.separator + TEST_FILE_NAME;
        File unzipFile = new File(unzipFilePath);

        if (unzipFile.exists()) return true;
        else return false;
    }

    public void updateResource() {

        new DownloadFileFromURL().execute(DOWNLOAD_URL);
    }


    private boolean unZip(String path, String zipname) {

        InputStream is;
        ZipInputStream zis;

        try {
            String filename;
            is = new FileInputStream(path + zipname);
            zis = new ZipInputStream(new BufferedInputStream(is));
            ZipEntry ze;
            byte[] buffer = new byte[1024];
            int count;

            while ((ze = zis.getNextEntry()) != null) {
                filename = ze.getName();

                Log.i(LOG_TAG, "File Name : " + filename);

                if (ze.isDirectory()) {
                    File fmd = new File(path + filename);
                    fmd.mkdirs();
                    continue;
                }

                FileOutputStream fout = new FileOutputStream(path + filename);

                while ((count = zis.read(buffer)) != -1) {
                    fout.write(buffer, 0, count);
                }

                fout.close();
                zis.closeEntry();
            }

            zis.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public interface DownloadCallBack {

        public void onBeforeDownLoad();

        public void onProgress(int soFar, int total);

        public void onCompleteDownload();

    }

    private class DownloadFileFromURL extends AsyncTask<String, Integer, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            if (mDownloadCallBack != null) {
                mDownloadCallBack.onBeforeDownLoad();
            }

        }

        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection conection = url.openConnection();
                conection.connect();

                // this will be useful so that you can show a tipical 0-100%
                // progress bar
                int lenghtOfFile = conection.getContentLength();


                // download the file
                InputStream input = new BufferedInputStream(url.openStream(),
                        8192);

                // Output stream
                OutputStream output = new FileOutputStream(mContext.getFilesDir() + File.separator + ZIP_FILE_NAME);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress((int)total, lenghtOfFile);

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            if (mDownloadCallBack != null) {
                mDownloadCallBack.onProgress(values[0], values[1]);
            }
        }

        @Override
        protected void onPostExecute(String s) {

            String path = mContext.getFilesDir() + File.separator;
            unZip(path, ZIP_FILE_NAME);

            if (mDownloadCallBack != null) {
                mDownloadCallBack.onCompleteDownload();
            }
        }
    }
}
