package com.example.myproject.Ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myproject.Adapter.Product_content_adapter;
import com.example.myproject.Product;
import com.example.myproject.ProductAdapter;
import com.example.myproject.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment2 newInstance(String param1, String param2) {
        BlankFragment2 fragment = new BlankFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    View view;

    RecyclerView recyclerView;
    RecyclerView recyclerView2;

    ArrayList<Product> list = new ArrayList<>();

    Product_content_adapter product_content_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_content, container, false);
        recyclerView = view.findViewById(R.id.RecyclerView);
        recyclerView2 = view.findViewById(R.id.RecyclerView1);
        // Create and set the layout manager for recyclerView
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager1);

// Create and set the layout manager for recyclerView2
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        list.add(new Product(R.drawable.anh1, "Header", "He'll want to use your yacht, and I don't want this thing smelling like fish.", "8ago"));
        list.add(new Product(R.drawable.anh2, "Header", "He'll want to use your yacht, and I don't want this thing smelling like fish.", "8ago"));
        list.add(new Product(R.drawable.anh3, "Header", "He'll want to use your yacht, and I don't want this thing smelling like fish.", "8ago"));
        product_content_adapter = new Product_content_adapter(getContext(), list);
        recyclerView.setAdapter(product_content_adapter);
        recyclerView2.setAdapter(product_content_adapter);
        return view;
    }
}