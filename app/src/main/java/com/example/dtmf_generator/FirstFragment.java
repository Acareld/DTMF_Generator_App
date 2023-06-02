package com.example.dtmf_generator;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dtmf_generator.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private static ToneGenerator generator;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        generator = new ToneGenerator(AudioManager.STREAM_MUSIC, 75);
        Animation fadeIN = AnimationUtils.loadAnimation(getContext(),R.anim.fadein);
        TextView freqText = view.findViewById(R.id.textView_freq);
        TextView freq = view.findViewById(R.id.textView2);
        CharSequence infoText = freq.getText();
        SpannableString contentInfo = new SpannableString(infoText);
        contentInfo.setSpan(new UnderlineSpan(), 0, infoText.length(), 0);
        freq.setText(contentInfo);


        binding.buttonUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean touched = false;
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    touched = true;
                    freqText.setText("1209Hz x 697Hz");
                }
                if(touched) {
                    generator.startTone(ToneGenerator.TONE_DTMF_1);
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    touched = false;
                    generator.stopTone();
                }
                return false;
            }
        });
        binding.buttonDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean touched = false;
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    touched = true;
                    freqText.setText("1336Hz x 697Hz");
                }
                if(touched) {
                    generator.startTone(ToneGenerator.TONE_DTMF_2);
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    touched = false;
                    generator.stopTone();
                }
                return false;
            }
        });
        binding.buttonRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean touched = false;
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    touched = true;
                    freqText.setText("1633Hz x 697Hz");
                }
                if(touched) {
                    generator.startTone(ToneGenerator.TONE_DTMF_A);
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    touched = false;
                    generator.stopTone();
                }
                return false;
            }
        });

        binding.buttonLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean touched = false;
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    touched = true;
                    freqText.setText("1477Hz x 697Hz");
                }
                if(touched) {
                    generator.startTone(ToneGenerator.TONE_DTMF_3);
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    touched = false;
                    generator.stopTone();
                }
                return false;
            }
        });
        binding.buttonInteract.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean touched = false;
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    touched = true;
                }
                if(touched) {
                    generator.startTone(ToneGenerator.TONE_DTMF_7);
                    freqText.setText("1209Hz x 852Hz");
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    touched = false;
                    generator.stopTone();
                }
                return false;
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        generator.release();
        binding = null;
    }



}