package dev.jabo.kree.components;

import java.awt.Graphics;

import dev.jabo.kree.Animation;
import dev.jabo.kree.Component;

public class Animator extends Component {

	private Animation[] allAnimation;
	private Animation activeAnimation;
	
	public Animator(Animation[] animationData) {
		this.allAnimation = animationData;
		this.name = "Animator";
	}
	
	@Override
	public void Update() {
		if(activeAnimation != null) 
			activeAnimation.Update();
	}

	@Override
	public void Render(Graphics g) {
		if(activeAnimation != null) {
			g.drawImage(activeAnimation.getCurrentFrame(), gameObject.transform.position.x, gameObject.transform.position.y, gameObject.transform.scale.x, gameObject.transform.scale.y, null);
		}
	}
	
	public void setActiveAnimation(String name) {
		for(Animation anim : allAnimation) {
			if(anim.getAnimationName() == name) {
				activeAnimation = anim;
			}
		}
	}

}
