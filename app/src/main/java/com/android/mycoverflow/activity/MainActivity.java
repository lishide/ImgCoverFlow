package com.android.mycoverflow.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.mycoverflow.adapter.CoverFlowAdapter;
import com.android.mycoverflow.bean.ChannelBean;
import com.img.coverflow.widget.CoverFlowView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;

    private CoverFlowView coverFlowView;
    private Button btnPrevious;
    private Button btnForward;
    private Button btnGetTop;
    private Button btnGetTopView;

    private List<ChannelBean> channelBeanList;
    public static final int[] channelImgs = {R.drawable.ic_ns1, R.drawable.ic_ns2,
            R.drawable.ic_ns3, R.drawable.ic_ns4, R.drawable.ic_ns5};
    public static final String[] channelNames = {"图片1", "图片2", "图片3", "图片4", "图片5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        initView();
        initListDataAndAction();
    }

    private void initView() {
        coverFlowView = (CoverFlowView) findViewById(R.id.coverflow);
        btnPrevious = (Button) findViewById(R.id.btn_previous);
        btnForward = (Button) findViewById(R.id.btn_forward);
        btnGetTop = (Button) findViewById(R.id.btn_get_top);
        btnGetTopView = (Button) findViewById(R.id.btn_get_top_view);
        btnPrevious.setOnClickListener(this);
        btnForward.setOnClickListener(this);
        btnGetTop.setOnClickListener(this);
        btnGetTopView.setOnClickListener(this);
    }

    private void initListDataAndAction() {
        channelBeanList = new ArrayList<>();
        for (int i = 0; i < channelNames.length; i++) {
            ChannelBean channelBean = new ChannelBean();
            channelBean.setImg(channelImgs[i]);
            channelBean.setName(channelNames[i]);
            channelBeanList.add(channelBean);
        }

        CoverFlowAdapter coverFlowAdapter = new CoverFlowAdapter(context, channelBeanList);
        coverFlowView.setAdapter(coverFlowAdapter);

        // 给coverFlowView的TOPView 添加点击事件监听
        coverFlowView.setOnTopViewClickListener(mOnTopViewClickListener);
    }

    private CoverFlowView.OnTopViewClickListener mOnTopViewClickListener = new CoverFlowView.OnTopViewClickListener() {
        @Override
        public void onClick(int position, View itemView) {
            ChannelBean channelBean = channelBeanList.get(position);

            Toast.makeText(context, "点击事件 position：" + position
                    + "， text：" + channelBean.getName(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_previous:
                coverFlowView.gotoPrevious();//向前一页
                break;
            case R.id.btn_forward:
                coverFlowView.gotoForward();//向后一页
                break;
            case R.id.btn_get_top://获取最上面Item的position
                int position = coverFlowView.getTopViewPosition();
                Toast.makeText(context, position + "", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_top_view://获取最上面Item的View
                CoverFlowAdapter.Holder holder = (CoverFlowAdapter.Holder) coverFlowView.getTopView().getTag();
                Toast.makeText(context, holder.tv.getText() + "", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
