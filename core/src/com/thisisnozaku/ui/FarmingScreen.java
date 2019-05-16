package com.thisisnozaku.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.thisisnozaku.GameState;

public class FarmingScreen implements UiComponentConfigurer {
    private Skin skin;

    public FarmingScreen(Skin skin) {
        this.skin = skin;
    }

    @Override
    public void configure(final Stage stage, final GameState state) {
        Table rootTable = (Table) stage.getActors().get(0);
        Table uiTable = new Table();

        state.getResources().entrySet().forEach(entry -> {
            final Label resourceNameLabel = new Label(entry.getValue().getResource().getDisplayName(), skin);
            resourceNameLabel.setAlignment(Align.center);
            resourceNameLabel.setColor(1, 1, 1, 1);
            entry.getValue().addObserver((o, arg) -> resourceNameLabel.setText(arg.toString()));
            resourceNameLabel.setDebug(true);
            uiTable.add(resourceNameLabel).width(200);
        });

        uiTable.row();

        state.getResources().entrySet().forEach(entry -> {
            final Label resourceValueLabel = new Label(Double.toString(entry.getValue().getAmount()), skin);
            resourceValueLabel.setAlignment(Align.center);
            resourceValueLabel.setColor(1, 1, 1, 1);
            entry.getValue().addObserver((o, arg) -> resourceValueLabel.setText(arg.toString()));
            resourceValueLabel.setDebug(true);
            uiTable.add(resourceValueLabel).width(200);
        });

        rootTable.add(uiTable);
        rootTable.row();

        Table gameplayTable = new Table();

        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button b = new Button(skin);
                gameplayTable.add(b).pad(15).size(65);
            }
            gameplayTable.row();
        }

        rootTable.add(gameplayTable).expandY();

    }
}
