package www.pdx.life.ykmtools.adapter;

import android.content.Context;

import java.util.List;

import www.pdx.life.ykmtools.R;
import www.pdx.life.ykmtools.base.adapter.AdapterM;
import www.pdx.life.ykmtools.base.adapter.ViewHolderM;
import www.pdx.life.ykmtools.bean.MessageBean;


/**
 * Created by wenxin on 2017/3/10.
 */

public class ListAdapter extends AdapterM<MessageBean> {

    public ListAdapter(Context context, int layoutId, List<MessageBean> dataArray) {
        super(context, layoutId, dataArray);
    }

    @Override
    public void convert(ViewHolderM holder, MessageBean model) {
       // 为个控件绑定内容
        holder.setText(R.id.tv_title, model.getTitle());
        holder.setText(R.id.tv_content, model.getContent());
        holder.setText(R.id.tv_comment, model.getComment() + "条评论");
        holder.setText(R.id.tv_read, model.getRead() + "阅读");
    }
}
