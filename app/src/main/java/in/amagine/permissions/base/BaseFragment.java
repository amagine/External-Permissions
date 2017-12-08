package in.amagine.permissions.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.amagine.permissions.interfaces.INavigationListener;

public class BaseFragment extends Fragment
{
    private int resource;
    protected INavigationListener mINavigationListener;

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        mINavigationListener = (INavigationListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(getResource(), container, false);
    }

    public int getResource()
    {
        return resource;
    }

    public void setResource(int resource)
    {
        this.resource = resource;
    }
}
