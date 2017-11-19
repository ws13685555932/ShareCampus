package com.wangsheng.sharecampus.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.util.ShowUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wangsheng
 * on 2017/10/14.
 */

public class SkillRecyclerAdapter {
    private List<HashMap<String,Object>> mData;
    private Context mContext;
    public SkillRecyclerAdapter(List<HashMap<String,Object>> mData,Context mContext){
        this.mData = mData;
        this.mContext = mContext;
    }
    int[] image = {R.drawable.image_head1,R.drawable.image_head2,R.drawable.image_head3,R.drawable.image_head4,R.drawable.image_head5};
    public CommonAdapter getAdapter(){
        return new CommonAdapter<HashMap<String,Object>>(mContext, R.layout.item_recy_skill_v,mData) {
            @Override
            protected void convert(ViewHolder holder, HashMap<String,Object> o, final int position) {
                ((TextView)holder.getView(R.id.title)).setText(o.get("title").toString());
                ((TextView)holder.getView(R.id.message)).setText(o.get("content").toString());
                ((TextView)holder.getView(R.id.theme)).setText(o.get("theme").toString());
                ((ImageView)holder.getView(R.id.imagehead)).setImageResource(image[position]);
                holder.setOnClickListener(R.id.add,new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ShowUtil.print("点击了"+position);
                        if(view.getTag()!=null&&view.getTag().equals(1)){
                            view.setTag(0);
                            ((ImageView)view).setImageResource(R.drawable.ic_add_blue);
                            ShowUtil.toast("取消关注");
                        }else{
                            view.setTag(1);
                            ((ImageView)view).setImageResource(R.drawable.ic_true);
                            ShowUtil.toast("关注成功");
                        }
                    }
                });
            }
        };
    }

}
