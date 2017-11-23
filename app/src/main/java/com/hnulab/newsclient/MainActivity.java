package com.hnulab.newsclient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class MainActivity extends Activity {

          private List<News> newsList;
          private ListView lv;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_inform);
                    //[1]找到控件
                    lv = (ListView) findViewById(R.id.lv);
                    //[2]准备listview要显示的数据 去服务器取数据
                    initListData();
          }

          //准备数据
          private void initListData() {
                    new Thread() {
                              @Override
                              public void run() {
                                        super.run();
                                        try {
                                                  //[1]去服务器取数据 http://192.168.1.3:8080/news.xml
                                                  String path = "http://39.108.151.208:9030/static/admin/news/news.xml";
                                                  URL url = new URL(path);
                                                  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                                  conn.setRequestMethod("GET");
                                                  conn.setReadTimeout(5000);
                                                  int code = conn.getResponseCode();
                                                  if (code == 200) {
                                                            //接收成功，读取数据
                                                            InputStream in = conn.getInputStream();
                                                            //解析xml
                                                            newsList = XmlparserUtils.parserXml(in);
                                                            //展示数据
                                                            runOnUiThread(new Runnable() {
                                                                      @Override
                                                                      //UI更新
                                                                      public void run() {
                                                                                //设置适配器
                                                                                lv.setAdapter(new NewsAdapter(getApplicationContext(),newsList));
                                                                      }
                                                            });

                                                  }

                                        } catch (Exception e) {
                                                  e.printStackTrace();
                                        }

                              }
                    }.start();
          }

}
