/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * 
 * @version 1.00
 */

package trail.concurrency;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Shows animated bouncing balls.
 * 
 * @author JiaweiM
 * @date Dec 11, 2015 9:01:12 AM
 */
public class BounceThread {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new BounceFrame();
				frame.setTitle("BounceThread");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * A runnable that animates a bouncing ball.
 */
class BallRunnable implements Runnable {
	private Ball ball;
	private Component component;
	public static final int STEPS = 1000;
	public static final int DELAY = 5;

	/**
	 * Constructs the runnable.
	 * 
	 * @param aBall the ball to bounce
	 * @param aComponent the component in which the ball bounces
	 */
	public BallRunnable(Ball aBall, Component aComponent) {
		ball = aBall;
		component = aComponent;
	}

	public void run() {
		try {
			for (int i = 1; i <= STEPS; i++) {
				ball.move(component.getBounds());
				component.repaint();
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {
		}
	}

}

class BounceFrame extends JFrame {
	private BallComponent comp;

	public BounceFrame() {
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addBall();
			}
		});

		addButton(buttonPanel, "Close", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}

	/**
	 * Adds a button to a container.
	 * 
	 * @param c the container
	 * @param title the button title
	 * @param listener the action listener for the button
	 */
	public void addButton(Container c, String title, ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}

	/**
	 * Adds a bouncing ball to the canvas and starts a thread to make it bounce
	 */
	public void addBall() {
		Ball b = new Ball();
		comp.add(b);
		Runnable r = new BallRunnable(b, comp);
		Thread t = new Thread(r);
		t.start();
	}
}
