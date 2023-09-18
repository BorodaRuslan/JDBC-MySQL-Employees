package org.example.app.controllers.positions;

import org.example.app.services.positions.PositionReadService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.positions.PositionReadView;

public class PositionReadController {

    PositionReadService service;
    PositionReadView view;

    public PositionReadController(PositionReadService service, PositionReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readPositions() {
        // Отримуємо результат
        String str = service.readPositions();
        // Передаємо результа на виведення
        view.getOutput(str);
        AppStarter.startApp();
    }
}
