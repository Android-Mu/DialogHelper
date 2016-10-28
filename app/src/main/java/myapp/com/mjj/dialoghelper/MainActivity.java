package myapp.com.mjj.dialoghelper;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Desc：对话框辅助类测试
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvCreateDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCreateDia = (TextView) findViewById(R.id.tv_create_dialog);
        tvCreateDia.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Random rand = new Random();
        int i = rand.nextInt(9);
        switch (i) {
            case 0:
                // 选择对话框
                final String[] items = new String[]{"Android", "Java", "JavaScript"};
                DialogHelper.getSelectDialog(this, items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "click..." + items[i], Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case 1:
                // 获取一个对话框对象进行操作
                DialogHelper.getDialog(MainActivity.this).show();
                break;
            case 2:
                // 创建耗时做操进度对话框
                DialogHelper.getWaitDialog(MainActivity.this, "加载中...").show();
                break;
            case 3:
                // 显示信息的对话框
                DialogHelper.getMessageDialog(MainActivity.this, "信息对话框").show();
                break;
            case 4:
                // 可定义标题、内容、按钮文字、监听对话框
                DialogHelper.getConfirmDialog(MainActivity.this, "Title", "Dialog Content...", "满意", "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "click...满意", Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "click...取消", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case 5:
                // 自定义Dialog内容,实现确定监听即可
                DialogHelper.getConfirmDialog(MainActivity.this, "Dialog Message...", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "sure Button", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case 6:
                // 可设置对话框内容和监听
                DialogHelper.getConfirmDialog(MainActivity.this, "DialogMessage...", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "sure", Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case 7:
                // 可设置内容、按钮文字、监听
                DialogHelper.getConfirmDialog(MainActivity.this, "Dialog content...", "Love", "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Love", Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case 8:
                // 单选对话框
                final String[] item = new String[]{"Android", "Java", "JavaScript"};
                DialogHelper.getSingleChoiceDialog(MainActivity.this, item, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "item--" + item[i], Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
        }
    }
}
