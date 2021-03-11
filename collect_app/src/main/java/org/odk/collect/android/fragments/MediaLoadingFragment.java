package org.odk.collect.android.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.Nullable;

import org.odk.collect.android.activities.FormEntryActivity;
import org.odk.collect.android.tasks.MediaLoadingTask;

public class MediaLoadingFragment extends Fragment {

    private MediaLoadingTask mediaLoadingTask;

    public void beginMediaLoadingTask(Uri uri) {
        mediaLoadingTask = new MediaLoadingTask((FormEntryActivity) getActivity());
        mediaLoadingTask.execute(uri);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (mediaLoadingTask != null) {
            mediaLoadingTask.onAttach((FormEntryActivity) getActivity());
        }
    }

    public boolean isMediaLoadingTaskRunning() {
        return mediaLoadingTask != null && mediaLoadingTask.getStatus() == AsyncTask.Status.RUNNING;
    }
}
