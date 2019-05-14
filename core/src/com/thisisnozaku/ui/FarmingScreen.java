package com.thisisnozaku.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.Align;
import com.thisisnozaku.GameState;

import java.util.Observable;
import java.util.Observer;

public class FarmingScreen implements UiComponentConfigurer {
    private Skin skin;

    public FarmingScreen(Skin skin) {
        this.skin = skin;
    }

    @Override
    public void configure(final Stage stage, GameState state) {
        VerticalGroup group = new VerticalGroup();
        group.align(Align.topLeft);
        group.setDebug(true, true);
//        group.setFillParent(true);

        // TODO: Extract Resource widget.
        final HorizontalGroup resourceGroup = new HorizontalGroup();
        resourceGroup.setFillParent(true);

        state.getResources().entrySet().forEach(entry -> {
            final Label resourceValueLabel = new Label(entry.getValue().getResource().getDisplayName(), skin);
            resourceValueLabel.setColor(1, 1, 1, 1);
            entry.getValue().addObserver((o, arg) -> resourceValueLabel.setText(arg.toString()));
            resourceValueLabel.setDebug(true);
            //resourceGroup.addActor(resourceValueLabel);
            group.addActor(resourceValueLabel);
        });

        //group.addActor(resourceGroup);

        //group.invalidateHierarchy();
        stage.addActor(group);
    }
}
