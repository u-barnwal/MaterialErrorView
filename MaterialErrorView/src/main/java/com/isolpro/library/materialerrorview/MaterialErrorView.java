/*
  Author: UB
  Version: v1.0
*/

package com.isolpro.library.materialerrorview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.isolpro.library.materialerrorview.databinding.MaterialErrorBoxBinding;

public class MaterialErrorView extends RelativeLayout {

  private MaterialErrorBoxBinding binding;

  private ErrorActionCallback actionCallback;

  public MaterialErrorView(Context context) {
    super(context);
    init(context, null, 0, 0);
  }

  public MaterialErrorView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs, 0, 0);
  }

  public MaterialErrorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr, 0);
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ErrorBox, 0, 0);

    binding = MaterialErrorBoxBinding.inflate(LayoutInflater.from(context));

    instantiate();
    initialize();
    listen();

    try {
      setIcon(typedArray.getDrawable(R.styleable.ErrorBox_eb_icon));
      setMessage(typedArray.getString(R.styleable.ErrorBox_eb_message));
      setActionText(typedArray.getString(R.styleable.ErrorBox_eb_action));
    } finally {
      typedArray.recycle();
    }

    addView(binding.getRoot());
  }

  private void instantiate() {
  }

  private void initialize() {
  }

  private void listen() {
    binding.ebAction.setOnClickListener(view -> {
      if (actionCallback != null)
        actionCallback.exec(null);
    });
  }

  public void setIcon(Drawable drawable) {
    if (drawable == null) {
      binding.ebIcon.setVisibility(View.GONE);
      return;
    }

    binding.ebIcon.setImageDrawable(drawable);
  }

  public void setMessage(String message) {
    if (message == null) {
      binding.ebMessage.setVisibility(View.GONE);
      return;
    }

    binding.ebMessage.setText(message);
  }

  public void setActionText(String text) {
    if (text == null) {
      binding.ebAction.setVisibility(View.GONE);
      return;
    }

    binding.ebAction.setText(text);
  }

  public void setActionCallback(ErrorActionCallback actionCallback) {
    this.actionCallback = actionCallback;
  }

  public void removeActionButton() {
    binding.ebAction.setVisibility(View.GONE);
  }
}
