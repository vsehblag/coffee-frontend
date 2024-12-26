package com.example.dealfinderapp_v3.ui.promotion;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dealfinderapp_v3.Promotion;
import com.example.dealfinderapp_v3.R;

public class PromotionDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_details);

        // Получаем данные об акции из Intent
        int promotionId = getIntent().getIntExtra("promotion_id", -1);
        System.out.println("id: " + promotionId);
        // Загрузите данные об акции из вашей базы данных или другого источника данных
        Promotion promotion = getPromotionDetails(promotionId);

        // Находим элементы макета для отображения данных об акции
        ImageView imageView = findViewById(R.id.image_promotion);
        TextView titleTextView = findViewById(R.id.text_promotion_title);
        TextView establishmentTextView = findViewById(R.id.text_establishment);
        TextView distanceTextView = findViewById(R.id.text_distance);
        TextView descriptionTextView = findViewById(R.id.text_description);
        // Другие элементы макета...

        // Заполняем элементы макета данными об акции
        if (promotion != null) {
            imageView.setImageDrawable(promotion.getImageDrawable());
            titleTextView.setText(promotion.getTitle());
            establishmentTextView.setText(promotion.getEstablishmentName());
            distanceTextView.setText(promotion.getDistance());
            descriptionTextView.setText(promotion.getDescription());
            // Заполните другие элементы макета данными об акции...
        }
    }

    // Метод для загрузки данных об акции из базы данных или другого источника данных
    private Promotion getPromotionDetails(int promotionId) {
        // Здесь реализуйте логику загрузки данных об акции по ее идентификатору из вашей базы данных или другого источника данных
        // Возвращаем данные об акции или null, если акция не найдена
        if (promotionId == 1) {
            return new Promotion(
                    1,
                    "Третий блин при покупке двух!",
                    "Самые вкусные блины - только у нас! Купите 2 блина и получите 3 в подарок!",
                    "Длинная блинная",
                    "Новосибирск, ул. Пирогова 14",
                    "20 км",
                    0,
                    getResources().getDrawable(R.drawable.im2),
                    10
            );
        } else if (promotionId == 2) {
            return new Promotion(
                    2,
                    "Шестое кофе - в подарок",
                    "Самый вкусный кофе в академгородке - у нас",
                    "Кофейня у Зебры",
                    "Новосибирск, ул. Пирогова 18",
                    "19 км",
                    0,
                    getResources().getDrawable(R.drawable.im3),
                    10
            );
        } else if (promotionId == 3) {
            return new Promotion(
                    3,
                    "Бесплатное пиво! Налетай!",
                    "Первый раз в Red Rabbit? Получи бесплатное пиво!",
                    "Red Rabbit",
                    "Новосибирск, ул. Ильича 6",
                    "21 км",
                    0,
                    getResources().getDrawable(R.drawable.im4),
                    10
            );
        }
        else {
            return null; // Если акция не найдена
        }
    }
}
