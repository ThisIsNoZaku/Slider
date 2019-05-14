package com.thisisnozaku.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.thisisnozaku.GameState;

public interface UiComponentConfigurer {
        void configure(Stage stage, GameState state);
}
