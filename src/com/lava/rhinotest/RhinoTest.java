
package com.lava.rhinotest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import org.mozilla.javascript.*;
import android.util.Log;

public class RhinoTest extends Activity {
	private static Scriptable m_global_scope = null;
	private Scriptable m_scope;
	private org.mozilla.javascript.Context cx;
    private static final String TAG = "RhinoTest";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
	    Log.e(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
	initGlobalScope();
	initScriptEngine();
	exitScriptEngine();
        
    }





	private void initGlobalScope()
	{
		Log.e(TAG,"initGlobalScope");
		org.mozilla.javascript.Context tempCx = org.mozilla.javascript.Context.enter();
		tempCx.setOptimizationLevel(-1);
		m_global_scope = tempCx.initStandardObjects();
		org.mozilla.javascript.Context.exit();
	}

	private void initScriptEngine() 
	{
		Log.e(TAG,"initScriptEngine");
		cx = org.mozilla.javascript.Context.enter();
		cx.setOptimizationLevel(-1);
		m_scope = cx.newObject(m_global_scope);
		m_scope.setPrototype(m_global_scope);
		m_scope.setParentScope(null);

	}





	private void exitScriptEngine()
	{
		Log.e(TAG,"exitScriptEngine");
		org.mozilla.javascript.Context.exit();
	}
}
