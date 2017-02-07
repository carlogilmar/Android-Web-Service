package firstapp.makingdevs.com.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import groovy.json.*
import groovy.transform.TypeChecked

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

        mButton.onClickListener= {
            //url= new URL("http://emailerv2.modulusuno.com/countTotal").text
            //mText.setText(url)


            Fluent.async {
                URLConnection connection
                connection = new URL("http://emailerv2.modulusuno.com/countTotal").openConnection()
                connection.requestMethod = 'GET'
                connection.doOutput = true
                def writer = new OutputStreamWriter(connection.outputStream)
                writer.flush()
                writer.close()
                connection.connect()
                println connection
                def response = connection.content.text
                println response
            } then { result ->
                println result.properties
            }
        }
    }
}
