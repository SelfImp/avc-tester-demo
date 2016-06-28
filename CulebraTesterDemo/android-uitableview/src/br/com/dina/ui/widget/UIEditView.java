package br.com.dina.ui.widget;

import br.com.dina.ui.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.dina.ui.model.IListItem;

public class UIEditView extends LinearLayout {

    private LayoutInflater mInflater;
    private LinearLayout mEditViewContainer;

    private CharSequence mTitle;
    private CharSequence mSubtitle;
    private int mImage;

    public UIEditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mEditViewContainer = (LinearLayout) mInflater.inflate(R.layout.edit_item_single, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.UIButton, 0, 0);
        mTitle = a.getString(R.styleable.UIButton_title_);

        if(mTitle != null) {
            ((TextView) mEditViewContainer.findViewById(R.id.title)).setText(mTitle.toString());
        } else {
            ((TextView) mEditViewContainer.findViewById(R.id.title)).setText("Phone :");
        }

        addView(mEditViewContainer, params);
    }

}