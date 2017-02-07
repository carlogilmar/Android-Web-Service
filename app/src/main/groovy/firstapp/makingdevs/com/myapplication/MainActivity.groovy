package firstapp.makingdevs.com.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import groovy.json.*

class MainActivity extends AppCompatActivity {

    TextView mText
    Button mButton
    def url

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mText = (TextView) findViewById(R.id.label)
        mButton = (Button) findViewById(R.id.button)
        println "Hola grovy------>"*100

        mButton.onClickListener={
            url= new URL("http://emailerv2.modulusuno.com/countTotal").text
            mText.setText(url)
        }
    }
}
