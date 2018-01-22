package com.example.thierrycouilleault.belotescore.View;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

/**
 * Created by thierrycouilleault on 10/12/2017.
 */

public class Slider {

    public Boolean isOpen;
    public LinearLayout toHide;
    final static int SPEED = 100;
    public Animation.AnimationListener openListener, closeListener;

    /**
     * Utilisée pour ouvrir ou fermer le menu.
     * @return true si le menu est désormais ouvert.
     */
    public boolean toggle() {
        //Animation de transition.
        TranslateAnimation animation = null;

        // On passe de ouvert à fermé (ou vice versa)
        isOpen = !isOpen;

        // Si le menu est déjà ouvert
        if (isOpen)
        {
            // Animation de translation du bas vers le haut
            animation = new TranslateAnimation(0.0f, 0.0f, -toHide.getHeight(), 0.0f);

            animation.setAnimationListener(openListener);
        } else
        {
            // Sinon, animation de translation du haut vers le bas
            animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -toHide.getHeight());
            animation.setAnimationListener(closeListener);
        }

        // On détermine la durée de l'animation
        animation.setDuration(SPEED);
        // On ajoute un effet d'accélération
        animation.setInterpolator(new AccelerateInterpolator());
        // Enfin, on lance l'animation



        return isOpen;
    }


}
