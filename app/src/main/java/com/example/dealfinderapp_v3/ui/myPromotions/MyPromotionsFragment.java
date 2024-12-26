package com.example.dealfinderapp_v3.ui.myPromotions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.dealfinderapp_v3.Promotion;
import com.example.dealfinderapp_v3.databinding.FragmentMyPromotionsBinding;
import com.example.dealfinderapp_v3.R; // Подставьте ваш путь к ресурсам

import java.util.ArrayList;
import java.util.List;

public class MyPromotionsFragment extends Fragment {

    private FragmentMyPromotionsBinding binding;
    private ListView listView;
    private MyPromotionsAdapter adapter;
    private List<Promotion> actionList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MyPromotionsViewModel myPromotionsViewModelViewModel =
                new ViewModelProvider(this).get(MyPromotionsViewModel.class);

        binding = FragmentMyPromotionsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView = root.findViewById(R.id.promotions_list); // Подставьте ваш идентификатор ListView
        actionList = new ArrayList<>();
        adapter = new MyPromotionsAdapter(requireContext(), actionList); // Используйте requireContext()
        listView.setAdapter(adapter);

        // Здесь добавьте вашу логику для заполнения списка акций (например, из базы данных или с сервера)
        // Пример добавления данных в список:
        actionList.add(new Promotion(1, "Третий блин при покупке двух!", "Самые вкусные блины - только у нас! Купите 2 блина и получите 3 в подарок!","Длинная блинная", "Новосибирск, ул. Пирогова 14", "20 км", 3, getResources().getDrawable(R.drawable.im2), 6));
        actionList.add(new Promotion(2, "Шестое кофе - в подарок", "Самый вкусный кофе в академгородке - у нас", "Кофейня у Зебры", "Новосибирск, ул. Пирогова 18", "19 км", 2, getResources().getDrawable(R.drawable.im3), 5));
        actionList.add(new Promotion(3, "Бесплатное пиво! Налетай!", "Первый раз в Red Rabbit? Получи бесплатное пиво!","Red Rabbit", "Новосибирск, ул. Ильича 6", "21 км", 5, getResources().getDrawable(R.drawable.im4), 10));

        adapter.notifyDataSetChanged();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
