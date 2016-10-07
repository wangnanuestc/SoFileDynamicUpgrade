package example.wangnan_xy.com.nativehotpatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import example.wangnan_xy.com.nativehotpatch.uttils.SoPatchUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private TextView mTextView = null;

    private Button mButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str = System.getProperty("java.library.path", ".");
        Log.d(TAG, "str = " + str);
        // Example of a call to a native method
        mTextView = (TextView) findViewById(R.id.sample_text);
        mTextView.setText(stringFromJNI());

        mButton = (Button) findViewById(R.id.sample_button);
        mButton.setOnClickListener(this);
    }

    public void onClick(View view) {

        SoPatchUtils.doPatch(getApplicationContext());

        System.loadLibrary("native-lib");

        String str = stringFromJNI();
        Log.d(TAG, "*****************str = " + str);

        mTextView.setText(str);
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
