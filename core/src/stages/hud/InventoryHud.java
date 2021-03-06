//package com.mygdx.stages.hud;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.InputProcessor;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Image;
//import com.badlogic.gdx.scenes.scene2d.ui.Label;
//import com.badlogic.gdx.scenes.scene2d.ui.Table;
//import com.badlogic.gdx.utils.viewport.FitViewport;
//import com.mygdx.config.Resources;
//import com.mygdx.items.Sword;
//
//import java.util.Locale;
//
//public class InventoryHud extends Stage implements InputProcessor {
//    private Texture texture;
//    private Table table;
//    private Inventory inventory;
//    private Label[] labelList;
//
//    public InventoryHud() {
//        super(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera()));
//        texture = new Texture(Resources.Inventory_INGAME_SCROLLBAR);
//
//        inventory = new Inventory();
//        inventory.addItem(new Sword(10));
//
//        labelList = new Label[6];
//        for (int i = 0; i < labelList.length; i++) {
//            labelList[i] = new Label(String.format(Locale.US, "%04d", inventory.getItem(0).getAmount()),
//                    new Label.LabelStyle(new BitmapFont(), Color.WHITE));
//        }
//
//        table = new Table();
//        //table.setDebug(true);
//        table.setWidth(Gdx.graphics.getWidth());
//        table.setHeight(Gdx.graphics.getHeight());
//        table.bottom();
//
//        //Generate inventory quick bar
//        //first row
//        for (int i = 0; i < Resources.INVENTORY_SCROLLBAR_SIZE; i++) {
//            Table innerTable = new Table();// Stack also useful?
//            innerTable.add(inventory.getItem(i).getImage());
//            innerTable.add(labelList[i]);
//            table.add(innerTable);
//        }
//        //second row
//        table.row();
//        for (int i = 0; i < Resources.INVENTORY_SCROLLBAR_SIZE; i++) {
//            Image scrollbarTexture = new Image(texture);
//            table.add(scrollbarTexture);
//        }
//        addActor(table);
//    }
//
//    public Stage getStage() {
//        return this;
//    }
//
//    public void update() {
//        for (int i = 0; i < Resources.INVENTORY_SCROLLBAR_SIZE; i++) {
//            labelList[i].setText(inventory.getItem(i).getAmount());
//        }
//        act();
//        draw();
//    }
//
//    @Override
//    public boolean keyDown(int keycode) {
//        switch (keycode) {
//            case Input.Keys.P:
//                inventory.addItem(new Sword(10));
//        }
//        return false;
//    }
//
//    public void dispose(){
//
//    }
//
//    @Override
//    public boolean keyUp(int keycode) {
//        return false;
//    }
//
//    @Override
//    public boolean keyTyped(char character) {
//        return false;
//    }
//
//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        return false;
//    }
//
//    @Override
//    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//        return false;
//    }
//
//    @Override
//    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        return false;
//    }
//
//    @Override
//    public boolean mouseMoved(int screenX, int screenY) {
//        return false;
//    }
//
//    @Override
//    public boolean scrolled(int amount) {
//        return false;
//    }
//}
