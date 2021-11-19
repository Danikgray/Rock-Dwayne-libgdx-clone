package ru.graystyle.skala;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.audio.Sound;

public class Game extends ApplicationAdapter {


    public SpriteBatch batch;
    public Texture skala1 ,skala2, shopSpr;
    public OrthographicCamera cam;
    public Rectangle shop;
    public Sound skalaS;

    @Override
    public void create() {
      batch = new SpriteBatch();
      skala1 = new Texture(Gdx.files.internal("skala1.jpg"));
      skala2 = new Texture(Gdx.files.internal("skala2.jpg"));
      shopSpr = new Texture(Gdx.files.internal("shop.png"));
      skalaS = Gdx.audio.newSound(Gdx.files.internal("skala.mp3"));
      shop = new Rectangle(128, Gdx.graphics.getHeight() - 128, shopSpr.getWidth(),shopSpr.getHeight());
      cam = new OrthographicCamera();
      cam.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.1f,0.1f,0.1f,1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        if(!Gdx.input.isTouched()){
        batch.draw(skala1,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());}
        else {
            skalaS.play();
            batch.draw(skala2,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        }
       // batch.draw(shopSpr,shop.x,shop.y);
        
        batch.end();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
        skalaS.dispose();
        skala2.dispose();
        skala1.dispose();
    }

    @Override
    public void pause() {
        super.pause();
    }

}
