package com.inftel.museoinftel.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.inftel.museoinftel.R;
import com.inftel.museoinftel.activity.CanvasActivity;
import com.inftel.museoinftel.entity.Obra;
import com.inftel.museoinftel.service.RequestObrasTask;
import com.inftel.museoinftel.utility.Conexion;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GalleryFragment extends Fragment {

    private GridView photoGrid;
    private int mPhotoSize, mPhotoSpacing;
    private ImageAdapter imageAdapter;
    List <Obra> listaObras;
    public List<String> CONTENT = new ArrayList<>();
    public List<String> ICONS = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            listaObras = new RequestObrasTask(getActivity()).execute(Conexion.MUSEO_SERVER+Conexion.OBRA_RESOURCE).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for(Obra o : listaObras){
            CONTENT.add(o.getTitulo());
            ICONS.add(o.getFoto());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery, null);

        mPhotoSize = getResources().getDimensionPixelSize(R.dimen.photo_size);
        mPhotoSpacing = getResources().getDimensionPixelSize(R.dimen.photo_spacing);

        imageAdapter = new ImageAdapter();

        photoGrid = (GridView) v.findViewById(R.id.albumGrid);

        photoGrid.setAdapter(imageAdapter);

        photoGrid.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (imageAdapter.getNumColumns() == 0) {
                    final int numColumns = (int) Math.floor(photoGrid.getWidth() / (mPhotoSize + mPhotoSpacing));
                    if (numColumns > 0) {
                        final int columnWidth = (photoGrid.getWidth() / numColumns) - mPhotoSpacing;
                        imageAdapter.setNumColumns(numColumns);
                        imageAdapter.setItemHeight(columnWidth);
                    }
                }
            }
        });

        return v;
    }

    public class ImageAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private int mItemHeight = 0;
        private int mNumColumns = 0;
        private RelativeLayout.LayoutParams mImageViewLayoutParams;

        public ImageAdapter() {
            mInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mImageViewLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
        }

        public int getCount() {
            return CONTENT.size();
        }

        public void setNumColumns(int numColumns) {
            mNumColumns = numColumns;
        }

        public int getNumColumns() {
            return mNumColumns;
        }

        public void setItemHeight(int height) {
            if (height == mItemHeight) {
                return;
            }
            mItemHeight = height;
            mImageViewLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mItemHeight);
            notifyDataSetChanged();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup parent) {

            if (view == null)
                view = mInflater.inflate(R.layout.photo_item, null);

            ImageView cover = (ImageView) view.findViewById(R.id.cover);
            TextView title = (TextView) view.findViewById(R.id.title);

            cover.setLayoutParams(mImageViewLayoutParams);

            if (cover.getLayoutParams().height != mItemHeight) {
                cover.setLayoutParams(mImageViewLayoutParams);
            }

            String photo = (ICONS.get(position % ICONS.size()));

            final int imageResource = getResources().getIdentifier("@drawable/" + photo, null, getActivity().getPackageName());

            cover.setImageBitmap((BitmapFactory.decodeResource(getResources(),imageResource)));

            title.setText(CONTENT.get(position % CONTENT.size()));

            final Context c = getActivity();

            cover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imageResource);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 10, baos);
                    byte[] b = baos.toByteArray();
                    String fileName = "cuadro.png";
                    try {
                        FileOutputStream fileOutStream = c.openFileOutput(fileName, Context.MODE_PRIVATE);
                        fileOutStream.write(b);
                        fileOutStream.close();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }

                    Intent intent = new Intent(getActivity(), CanvasActivity.class);
                    intent.putExtra("canvas", new Gson().toJson(listaObras.get(position % CONTENT.size())));
                    intent.putExtra("picname", fileName);
                    startActivity(intent);
                }
            });
            return view;
        }


    }
}
