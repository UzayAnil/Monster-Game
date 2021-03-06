package player;

import Enums.Buttons;
import Enums.Entity;
import animations.AnimationHandler;
import camera.Camera;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;
import networking.ServerClientWrapper;

public class GamePadInput implements ControllerListener {
    private Camera camera;
    private ServerClientWrapper wrapper;
    private Entity entity;
    private AnimationHandler animationHandler;

    public GamePadInput(Entity entity, ServerClientWrapper wrapper, Camera camera, AnimationHandler animationHandler) {
        this.camera = camera;
        this.wrapper = wrapper;
        this.entity = entity;
        this.animationHandler = animationHandler;
    }

    @Override
    public boolean axisMoved(com.badlogic.gdx.controllers.Controller controller, int axisCode, float value) {
        float x = controller.getAxis(1);
        camera.move(x, 0);
        return false;
    }

    @Override
    public boolean povMoved(com.badlogic.gdx.controllers.Controller controller, int povCode, PovDirection value) {
        return false;
    }

    @Override
    public boolean xSliderMoved(com.badlogic.gdx.controllers.Controller controller, int sliderCode, boolean value) {
        return false;
    }

    @Override
    public boolean ySliderMoved(com.badlogic.gdx.controllers.Controller controller, int sliderCode, boolean value) {
        return false;
    }

    @Override
    public boolean accelerometerMoved(com.badlogic.gdx.controllers.Controller controller, int accelerometerCode, Vector3 value) {
        return false;
    }

    public void connected(com.badlogic.gdx.controllers.Controller controller) {
        System.out.println("Controller connected");
    }

    public void disconnected(com.badlogic.gdx.controllers.Controller controller) {
        System.out.println("Controller disconnected");
    }

    @Override
    public boolean buttonDown(com.badlogic.gdx.controllers.Controller controller, int buttonCode) {
        Buttons button;
        switch (buttonCode) {
            case 0:
                button = Buttons.A;
                break;
            case 1:
                button = Buttons.B;
                break;
            case 2:
                button = Buttons.X;
                break;
            case 3:
                button = Buttons.Y;
                break;
            case 4:
                button = Buttons.LB;
                break;
            case 5:
                button = Buttons.RB;
                break;
            case 6:
                button = Buttons.TAB;
                break;
            case 7:
                button = Buttons.MENU;
                break;
            default: button = Buttons.A;
        }
        animationHandler.buttonPressed(button);
        return false;
    }

    @Override
    public boolean buttonUp(com.badlogic.gdx.controllers.Controller controller, int buttonCode) {
        return false;
    }
}
