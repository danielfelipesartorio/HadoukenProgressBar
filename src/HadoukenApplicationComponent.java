import com.intellij.ide.ui.LafManager;
import com.intellij.ide.ui.LafManagerListener;
import com.intellij.ide.ui.laf.LafManagerImpl;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;


public class HadoukenApplicationComponent implements ApplicationComponent {
    private int shownProgressBars;
    private boolean isShown;

    public HadoukenApplicationComponent(LafManagerImpl lafManager) {
        lafManager.addLafManagerListener(new LafManagerListener() {
            @Override
            public void lookAndFeelChanged(LafManager lafManager) {
                updateProgressBarUi();
            }
        });
    }

    @Override
    public void initComponent() {
        updateProgressBarUi();
    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override

    public String getComponentName() {
        return "HadoukenLafUpdater";
    }

    private void updateProgressBarUi() {
        UIManager.put("ProgressBarUI", HadoukenProgressBarUi.class.getName());
        UIManager.getDefaults().put(HadoukenProgressBarUi.class.getName(), HadoukenProgressBarUi.class);
    }

    static HadoukenApplicationComponent getInstance() {
        return ApplicationManager.getApplication().getComponent(HadoukenApplicationComponent.class);
    }
}
