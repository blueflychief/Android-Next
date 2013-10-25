package com.douban.ui.samples;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import butterknife.InjectView;
import butterknife.Views;
import com.douban.ui.dialog.AlertDialogFragment;

/**
 * User: mcxiaoke
 * Date: 13-10-25
 * Time: 下午3:50
 */

/**
 * AlertDialogFragment使用示例
 */
public class AlertDialogSamples extends BaseActivity {
    public static final String TAG = AlertDialogSamples.class.getSimpleName();

    @InjectView(android.R.id.button1)
    Button mButton1;
    @InjectView(android.R.id.button2)
    Button mButton2;
    @InjectView(android.R.id.button3)
    Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_dialog);
        Views.inject(this);
        getSupportActionBar().setTitle(TAG);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mButton1.setText("简单对话框");
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(false);
            }
        });
        mButton2.setText("列表对话框");
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(true);
            }
        });
        mButton3.setText("自定义对话框");
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    private void showAlertDialog(boolean list) {
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this);
        builder.setTitle(list ? "列表对话框" : "简单对话框");
        if (list) {
            String[] items = new String[10];
            for (int i = 0; i < 10; i++) {
                items[i] = "List Item " + i;
            }
            builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    showToast("List Item Clicked: " + which);
                }
            });
        } else {
            builder.setMessage("江上春风留客舟，无穷归思满东流。与君尽日闲临水，贪看飞花忘却愁。你确定要关闭对话框？");
        }
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                showToast("Positive Button Clicked!");
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                showToast("Negative Button Clicked!");
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                showToast("AlertDialogFragment is dismissed!");
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                showToast("AlertDialogFragment is cancelled!");
            }
        });
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                showToast("onKey() keyCode=" + keyCode);
                return false;
            }
        });
        builder.setCancelable(true);
        builder.setCanceledOnTouchOutside(false);
        AlertDialogFragment dialog = builder.create();
        dialog.show(getSupportFragmentManager(), AlertDialogFragment.TAG);
    }

    private void showCustomDialog() {
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this);
        builder.setCustomTitle(LayoutInflater.from(this).inflate(R.layout.dialog_custom_title, null));
        builder.setView(LayoutInflater.from(this).inflate(R.layout.dialog_custom, null));
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                showToast("Positive Button Clicked!");
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                showToast("Negative Button Clicked!");
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                showToast("AlertDialogFragment is dismissed!");
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                showToast("AlertDialogFragment is cancelled!");
            }
        });
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                showToast("onKey() keyCode=" + keyCode);
                return false;
            }
        });
        builder.setCancelable(true);
        builder.setCanceledOnTouchOutside(false);
        AlertDialogFragment dialog = builder.create();
        dialog.show(getSupportFragmentManager(), AlertDialogFragment.TAG);
    }
}
