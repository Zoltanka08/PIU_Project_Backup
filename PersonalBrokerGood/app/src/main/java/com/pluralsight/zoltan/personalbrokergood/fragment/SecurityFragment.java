package com.pluralsight.zoltan.personalbrokergood.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pluralsight.zoltan.personalbrokergood.R;

import MockDatabase.Models.Database.IndexData;
import MockDatabase.Models.Security;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnSecurityInteractionListener}
 * interface.
 */
public class SecurityFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String INDEX_POSITION = "IndexPosition";
    // TODO: Customize parameters
    private String indexId = "";
    private OnSecurityInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SecurityFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SecurityFragment newInstance(String indexId) {
        SecurityFragment fragment = new SecurityFragment();
        Bundle args = new Bundle();
        args.putString(INDEX_POSITION, indexId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            indexId = getArguments().getString(INDEX_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_security_list, container, false);

        IndexData.setupSecuritiesOfIndex();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new SecurityAdapter(IndexData.securitiesOfIndex, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSecurityInteractionListener) {
            mListener = (OnSecurityInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnSecurityInteractionListener {
        // TODO: Update argument type and name
        void onSecurityInteraction(Security item);
    }
}
