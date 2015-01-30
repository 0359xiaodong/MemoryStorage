package com.nutegg.memorystorage;

import java.io.File;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView textView = (TextView)MainActivity.this.findViewById(R.id.tv);
		
		sdSize(textView);
	}

	private void sdSize(TextView textView) {
		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
			File path = Environment.getExternalStorageDirectory();
			StatFs stat = new StatFs(path.getPath());
			Long blockSize = stat.getBlockSizeLong();
			Long totalBlocks = stat.getBlockCountLong();
			Long totalVBlocks = stat.getAvailableBlocksLong();
			Long totalSize = blockSize * totalBlocks;
			Long totalVSize = blockSize * totalVBlocks;
			
			String totalStar = Formatter.formatFileSize(this, totalSize);
			String availableStae = Formatter.formatFileSize(this, totalVSize);
			textView.setText("SD�������ڴ�����Ϊ:"+totalStar+"\nSD����ʣ������Ϊ"+availableStae);
		}else{
			textView.setText("�����ֻ�û�в���SD������SD���Ӵ�����!");
		}
	}
	
	private void dataSize(TextView textView) {
		
			File path = Environment.getDataDirectory();
			StatFs stat = new StatFs(path.getPath());
			Long blockSize = stat.getBlockSizeLong();
			Long totalBlocks = stat.getBlockCountLong();
			Long totalVBlocks = stat.getAvailableBlocksLong();
			Long totalSize = blockSize * totalBlocks;
			Long totalVSize = blockSize * totalVBlocks;
			
			String totalStar = Formatter.formatFileSize(this, totalSize);
			String availableStae = Formatter.formatFileSize(this, totalVSize);
			textView.setText("SD�������ڴ�����Ϊ:"+totalStar+"\nSD����ʣ������Ϊ"+availableStae);
		
	}



}
