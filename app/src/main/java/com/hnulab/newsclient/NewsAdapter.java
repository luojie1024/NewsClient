package com.hnulab.newsclient;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.List;

/**
 * Description：定义数据适配器
 * Auther：luojie
 * E-mail：luojie@hnu.edu.cn
 * Time：2017/11/17 14:53
 */
class NewsAdapter extends BaseAdapter {
          private List<News> newsList;
          private Context context;

          public NewsAdapter(Context context,List<News> newsList){
                    this.newsList=newsList;
                    this.context=context;
          }

          @Override
          public int getCount() {
                    return newsList.size();
          }

          @Override
          public Object getItem(int position) {
                    return null;
          }

          @Override
          public long getItemId(int position) {
                    return 0;
          }

          @Override
          public View getView(int position, View convertView, ViewGroup parent) {
                    View view;
                    if (convertView == null) {
                              view = View.inflate(context, R.layout.activity_inform_item, null);
                    } else {
                              view = convertView;
                    }
                    //找到控件
                    SmartImageView iv_icon = (SmartImageView) view.findViewById(R.id.iv_icon);
                    TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
                    TextView tv_desc = (TextView) view.findViewById(R.id.tv_desc);
                    TextView tv_type = (TextView) view.findViewById(R.id.tv_type);
                    //显示数据
                    iv_icon.setImageUrl(newsList.get(position).getImage());
                    tv_title.setText(newsList.get(position).getTitle());
                    tv_desc.setText(newsList.get(position).getDescription());
                    String typee = newsList.get(position).getType();
                    Integer type = Integer.parseInt(typee);
                    String comment = newsList.get(position).getComment();
                    switch (type) {
                              case 1:
                                        tv_type.setText(comment + "跟帖");
                                        break;
                              case 2:
                                        tv_type.setText("国内");
                                        break;
                              case 3:
                                        tv_type.setText("国外");
                                        break;
                              default:
                                        break;
                    }
                    return view;
          }
}
