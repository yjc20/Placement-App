package com.android.letsgetplaced.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.letsgetplaced.R;
import com.android.letsgetplaced.datamodel.Resume;
import com.android.letsgetplaced.helper.ResumeFragment;
import com.android.letsgetplaced.helper.TextChangeListener;

public class EssentialsFragment extends ResumeFragment {

    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new EssentialsFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =
                inflater.inflate(R.layout.fragment_essentials, container, false);

        final Resume resume = getResume();

        EditText skillsText = root.findViewById(R.id.input_skills);
        skillsText.setText(resume.skills);
        skillsText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                resume.skills = s.toString();
            }
        });
        EditText languagesText = root.findViewById(R.id.input_languages);
        languagesText.setText(resume.languages);
        languagesText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                resume.languages = s.toString();
            }
        });
        return root;
    }
}
