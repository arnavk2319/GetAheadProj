package com.contentful.hello.android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView expandedDetailTextView, retailPrice1Text,invoicePrice1Text,baseInfoText1,freightInfo1,optionsInfoTextView,retailPrice2Text,invoicePrice2Text,baseInfoText2,freightInfoText2,totalInfoTextView;
    TableLayout costInfoTableLayout,optionsInfoTable;
    LinearLayout dropDowNLayout;
    Button refreshButton;

    private FirebaseFirestore mFirestore;


    private SwipeRefreshLayout swipeRefreshLayout2;

    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //     * @param param1 Parameter 1.
     //     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance() {
        DetailsFragment fragment = new DetailsFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.drop_down_details,container, false);

//        expandedDetailTextView = rootView.findViewById(R.id.expandedDetailTextView);
        retailPrice1Text = rootView.findViewById(R.id.retailPrice1);
        invoicePrice1Text = rootView.findViewById(R.id.invoicePrice1);
        baseInfoText1 = rootView.findViewById(R.id.baseInfo1);
        freightInfo1 = rootView.findViewById(R.id.freightInfo1);
        optionsInfoTextView = rootView.findViewById(R.id.options_info_title);
        retailPrice2Text = rootView.findViewById(R.id.retailPrice2);
        invoicePrice2Text = rootView.findViewById(R.id.invoicePrice2);
        baseInfoText2 = rootView.findViewById(R.id.baseInfo2);
        freightInfoText2 = rootView.findViewById(R.id.freightInfo2);
        totalInfoTextView = rootView.findViewById(R.id.totalTextView);
//        refreshButton = (Button)getActivity().findViewById(R.id.refreshButton);

        dropDowNLayout = rootView.findViewById(R.id.drop_down_layout);

        costInfoTableLayout = rootView.findViewById(R.id.cost_info_table);
        optionsInfoTable = rootView.findViewById(R.id.options_info_table);

//        swipeRefreshLayout2 = rootView.findViewById(R.id.pullToRefresh2);

        mFirestore = FirebaseFirestore.getInstance();

        if(getArguments()!=null) {
            String test = getArguments().getString("sample");
            retailPrice1Text.setText(test);
        }


        refreshButton.setOnClickListener(this);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),"error : FETCHING",Toast.LENGTH_LONG).show();

            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(),"error : FETCHING",Toast.LENGTH_LONG).show();

    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
