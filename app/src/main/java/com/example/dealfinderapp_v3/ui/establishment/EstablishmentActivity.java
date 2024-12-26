package com.example.dealfinderapp_v3.ui.establishment;

import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dealfinderapp_v3.R;

public class EstablishmentActivity extends AppCompatActivity implements View.OnClickListener {

    // Добавляем переменную для хранения идентификатора заведения
    private int establishmentId;
    // Добавляем переменные для хранения данных о заведении (заглушки)
    private Establishment establishment;
    private ImageView posterImageView;
    private View expandedTab = null;
    private TextView nameTextView, workingHoursTextView, establishmentDesctiption, establishmentAddress;
    private View menuTab, promotionsTab, pointsTab, reviewsTab, aboutTab;
    private LinearLayout menuContent, promotionsContent, pointsContent, reviewsContent, aboutContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment);

        // Получаем переданный идентификатор заведения из интента
        establishmentId = getIntent().getIntExtra("establishment_id", -1);

        // Загружаем данные о заведении с использованием переданного идентификатора (заглушка)
        establishment = loadEstablishmentData(establishmentId);

        // Инициализация views
        posterImageView = findViewById(R.id.poster_image_view);
        nameTextView = findViewById(R.id.name_text_view);
        workingHoursTextView = findViewById(R.id.working_hours_text_view);

        menuTab = findViewById(R.id.menu_tab_layout);
        promotionsTab = findViewById(R.id.promotions_tab_layout);
        pointsTab = findViewById(R.id.points_tab_layout);
        reviewsTab = findViewById(R.id.reviews_tab_layout);
        aboutTab = findViewById(R.id.about_tab_layout);

        // Инициализация содержимого вкладок
        menuContent = findViewById(R.id.menu_content);
        promotionsContent = findViewById(R.id.promotions_content);
        pointsContent = findViewById(R.id.points_content);
        reviewsContent = findViewById(R.id.reviews_content);
        aboutContent = findViewById(R.id.about_content);

        establishmentDesctiption = findViewById(R.id.establishment_description);
        establishmentAddress = findViewById((R.id.establishment_address));

        //заполняем данными
        posterImageView.setImageDrawable(establishment.getPoster());
        nameTextView.setText(establishment.getName());
        workingHoursTextView.setText(establishment.getWorkingHours());
        establishmentDesctiption.setText(establishment.getDescription());
        establishmentAddress.setText(establishment.getAddress());


        // Установка слушателей кликов
        menuTab.setOnClickListener(this);
        promotionsTab.setOnClickListener(this);
        pointsTab.setOnClickListener(this);
        reviewsTab.setOnClickListener(this);
        aboutTab.setOnClickListener(this);

        // По умолчанию открываем вкладку "О заведении"
        expandTab(aboutContent);
    }


    // Заглушка для загрузки данных о заведении из базы данных или другого источника
    private Establishment loadEstablishmentData(int establishmentId) {
        // Здесь нужно реализовать загрузку данных о заведении из базы данных или другого источника
        // Например, можно использовать Retrofit для запроса данных к API или загрузки из SQLite базы данных
        // Заглушка: создаем фиктивное заведение с некоторыми данными
        Establishment establishment = new Establishment();
        if (establishmentId == 1) {
            establishment.setName("Brewsell");
            establishment.setDescription("В настоящее время секретная городская кофейня уже не очень секретная.");
            establishment.setWorkingHours("с 07:30 до 22:30");
            establishment.setAddress("Проспект Карла Маркса, 41, Новосибирск, Новосибирская обл.");
            establishment.setDistance("0.5 км");
            establishment.setPoster(getResources().getDrawable(R.drawable.comein_poster));
        } else if (establishmentId == 2) {
            establishment.setName("Кофейная карта");
            establishment.setDescription("Какао на банановом/миндальном/кокосовом молоке. Какао с маршмелоу. Авторский кофе. Банан в шоколаде..");
            establishment.setWorkingHours("с 07:30 до 24:00");
            establishment.setAddress("Проспект Карла Маркса, 39, Новосибирск, Новосибирская обл.");
            establishment.setDistance("0.3 км");
            establishment.setPoster(getResources().getDrawable(R.drawable.estab_poster));
        }

        // Здесь можно загрузить другие данные о заведении, например, его расписание работы и т. д.
        return establishment;
    }

    @Override
    public void onClick(View v) {
        // Сворачиваем все вкладки
        collapseAllTabs();

        // Разворачиваем выбранную вкладку
        if (v == menuTab) {
            expandTab(menuContent);
        } else if (v == promotionsTab) {
            expandTab(promotionsContent);
        } else if (v == pointsTab) {
            expandTab(pointsContent);
        } else if (v == reviewsTab) {
            expandTab(reviewsContent);
        } else if (v == aboutTab) {
            expandTab(aboutContent);
        }
    }


    private void collapseAllTabs() {
        // Сворачиваем все вкладки
        collapseTab(menuContent);
        collapseTab(promotionsContent);
        collapseTab(pointsContent);
        collapseTab(reviewsContent);
        collapseTab(aboutContent);
    }

    private void expandTab(View tabContent) {
        // Разворачиваем выбранное содержимое вкладки
        if (expandedTab == tabContent) {
            // Если уже развернуто, сворачиваем его
            collapseTab(tabContent);
            expandedTab = null;
        } else {
            // Сворачиваем ранее развернутое содержимое вкладки
            collapseAllTabs();
            // Разворачиваем выбранное содержимое вкладки
            expandTabContent(tabContent);
            expandedTab = tabContent;
        }
    }

    private void collapseTab(View tabContent) {
        // Сворачиваем содержимое вкладки
        if (tabContent != null) {
            tabContent.setVisibility(View.GONE);
        }
    }

    private void expandTabContent(View tabContent) {
        // Разворачиваем содержимое выбранной вкладки
        if (tabContent != null) {
            tabContent.setVisibility(View.VISIBLE);
        }
    }
}

