package com.hnulab.newsclient;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：luojie
 * 邮箱：550997728@qq.com
 * 时间：2016/2/4 13:34
 */
public class XmlparserUtils {
          public static List<News> parserXml(InputStream in) {
                    List<News> newsLists=null;
                    try {
                              News news = null;
                              //[1]获取解析器
                              XmlPullParser parser = Xml.newPullParser();
                              //[2]设置解析器要解析的内容
                              parser.setInput(in, "utf-8");
                              //[3]获取解析事件
                              int type = parser.getEventType();
                              //[4]不停的向下解析
                              while (type != XmlPullParser.END_DOCUMENT) {
                                        //[5]具体判断一下解析的事哪个开始标签
                                        switch (type)  {
                                                  case XmlPullParser.START_TAG:
                                                            //解析开始节点
                                                            if ("channel".equals(parser.getName())) {
                                                                      //创建一个List集合
                                                                      newsLists = new ArrayList<News>();
                                                            } else if ("item".equals(parser.getName())) {
                                                                      //创建一个news对象
                                                                      news = new News();
                                                            } else if ("title".equals(parser.getName())) {
                                                                      news.setTitle(parser.nextText());

                                                            } else if ("description".equals(parser.getName())) {
                                                                      news.setDescription(parser.nextText());

                                                            } else if ("image".equals(parser.getName())) {
                                                                      news.setImage(parser.nextText());

                                                            } else if ("type".equals(parser.getName())) {
                                                                      news.setType(parser.nextText());

                                                            } else if ("comment".equals(parser.getName())) {
                                                                      news.setComment(parser.nextText());
                                                            }
                                                            break;
                                                  case XmlPullParser.END_TAG:
                                                            if ("item".equals(parser.getName())) {
                                                                      //把javabean添加到集合
                                                                      newsLists.add(news);
                                                            }
                                                            break;
                                        }
                                        //不停的向下解析
                                        type=parser.next();
                              }
                    } catch (Exception e) {
                              e.printStackTrace();
                    }
                    return newsLists;
          }


}
