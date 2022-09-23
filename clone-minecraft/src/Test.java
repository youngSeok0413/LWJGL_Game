import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.glfw.GLFWVidMode;

public class Test{
	
	public static void main(String[] args) {
		if(!glfwInit()) {
			System.err.println("Failed to init GLFW");
			System.exit(1);
		}
		
		long window = glfwCreateWindow(640, 480, "MY LWJGL Program", 0, 0);
		if(window == 0) {
			System.err.println("Failed to create window");
			System.exit(1);
		}
		
		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window,(videoMode.width() - 640)/2, (videoMode.height() - 480)/2);
		
		glfwShowWindow(window);
		
		glfwMakeContextCurrent(window);
		
		GL.createCapabilities();
		
		Texture tex = new Texture("./res/shutup.png");
		
		glEnable(GL_TEXTURE_2D);
		
		while(!glfwWindowShouldClose(window)) {
			glfwPollEvents();
			
			tex.bind();
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			glBegin(GL_QUADS);
			glTexCoord2f(0f, 0f);
			glVertex2f(-0.5f, 0.5f);
			
			glTexCoord2f(1f, 0f);
			glVertex2f(0.5f, 0.5f);
			
			glTexCoord2f(1f, 1f);
			glVertex2f(0.5f, -0.5f);
			
			glTexCoord2f(0f, 1f);
			glVertex2f(-0.5f, -0.5f);
			glEnd();
			
			glfwSwapBuffers(window);
		}
		
		tex.unbind();
		glfwTerminate();
	}

}