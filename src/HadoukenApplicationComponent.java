import com.intellij.ide.ui.LafManager;
import com.intellij.ide.ui.LafManagerListener;
import com.intellij.ide.ui.laf.LafManagerImpl;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;


public class HadoukenApplicationComponent {
    public HadoukenApplicationComponent() {
        LafManager.getInstance().addLafManagerListener(__ -> updateProgressBarUi());
        updateProgressBarUi();
    }
    private void updateProgressBarUi() {
        UIManager.put("ProgressBarUI", HadoukenProgressBarUi.class.getName());
        UIManager.getDefaults().put(HadoukenProgressBarUi.class.getName(), HadoukenProgressBarUi.class);
    }
}
