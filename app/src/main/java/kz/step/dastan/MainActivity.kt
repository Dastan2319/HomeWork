package kz.step.dastan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    var sendMsg:Button?=null;
    var sendLoginPass:Button?=null;
    var login:EditText?=null;
    var password:EditText?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
        initListener();
    }

    fun initView(){
        password=findViewById(R.id.edit_text_activity_password);
        login=findViewById(R.id.edit_text_activity_login);
        sendLoginPass=findViewById(R.id.btn_activity_main_send_login_pass);
        sendMsg=findViewById(R.id.btn_activity_main_say_hello);
    }
    fun initListener(){
        sendMsg!!.setOnClickListener(View.OnClickListener {
            val msgIntent = Intent().setAction(Intent.ACTION_SEND)
            msgIntent.putExtra(Intent.EXTRA_TEXT,"Hello i have written Intent which sending you this message");
            msgIntent.setType("text/plain")
//            msgIntent.setPackage("com.whatsapp");
            startActivity(msgIntent);
        })
        sendLoginPass!!.setOnClickListener(View.OnClickListener {
            val msgIntent=Intent().setAction(Intent.ACTION_SEND);
            msgIntent.putExtra(Intent.EXTRA_TEXT,"Login:"+login!!.text.toString()+";Pass:"+password!!.text.toString());
            msgIntent.setType("text/plain");
            startActivity(msgIntent);
        })
    }

}