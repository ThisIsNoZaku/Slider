package com.thisisnozaku;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.kotcrab.vis.ui.VisUI;
import com.thisisnozaku.resources.ResourceDefinition;
import com.thisisnozaku.resources.ResourceState;
import com.thisisnozaku.resources.ResourceStateBuilder;
import com.thisisnozaku.ui.FarmingScreen;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class CivCombiner extends ApplicationAdapter {
	Stage stage;
	FarmingScreen farmingScreen;
	GameState gameState;
	Skin skin;
	Camera camera;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		// TODO: Don't hard-code ui definition file.
		VisUI.load();
		skin = VisUI.getSkin();
		try {
			ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
			ObjectReader objectReader = objectMapper.readerFor(GameConfiguration.class);
			GameConfiguration o = objectReader.readValue(Gdx.files.internal("game.yaml").file());

			Map<ResourceDefinition, ResourceState> resources = o.getResources().values().stream().collect(Collectors.toMap(r -> r, r ->
				new ResourceStateBuilder().setResource(r).setMaximum(Integer.MAX_VALUE).setMinimum(0).setInitialQuantity(0).createResourceState()
			));
			gameState = new GameState();
			gameState.setResources(resources);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		farmingScreen = new FarmingScreen(skin);
	    stage = configureRootState(new Stage());
	    farmingScreen.configure(stage, gameState);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
		VisUI.dispose();
	}

	public Stage configureRootState(Stage stage) {
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		table.top();
		stage.setDebugAll(true);
		return stage;
	}
}
