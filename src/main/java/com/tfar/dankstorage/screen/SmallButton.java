package com.tfar.dankstorage.screen;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;

public class SmallButton extends Button {
  public SmallButton(int x, int y, int widthIn, int heightIn, String buttonText, IPressable callback)
  {
    super(x, y, widthIn, heightIn, buttonText, callback);
  }

  @Override
  public void render(int mouseX, int mouseY, float partialTicks)
  {
    if (visible)
    {
      Minecraft minecraft = Minecraft.getInstance();
      FontRenderer fontrenderer = minecraft.fontRenderer;
      minecraft.getTextureManager().bindTexture(WIDGETS_LOCATION);

      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

      isHovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;

      int i = getYImage(isHovered);

      GlStateManager.enableBlend();
      GlStateManager.blendFuncSeparate(770, 771, 1, 0);
      GlStateManager.blendFunc(770, 771);

      int halfwidth1 = this.width / 2;
      int halfwidth2 = this.width - halfwidth1;
      int halfheight1 = this.height / 2;
      int halfheight2 = this.height - halfheight1;
      blit(x, y, 0,
              46 + i * 20, halfwidth1, halfheight1);
      blit(x + halfwidth1, y, 200 - halfwidth2,
              46 + i * 20, halfwidth2, halfheight1);

      blit(x, y + halfheight1,
              0, 46 + i * 20 + 20 - halfheight2, halfwidth1, halfheight2);
      blit(x + halfwidth1, y + halfheight1,
              200 - halfwidth2, 46 + i * 20 + 20 - halfheight2, halfwidth2, halfheight2);

      int textColor = 14737632;

      if (packedFGColor != 0)
      {
        textColor = packedFGColor;
      }
      else if (!this.visible)
      {
        textColor = 10526880;
      }
      else if (this.isHovered)
      {
        textColor = 16777120;
      }

      this.drawCenteredString(fontrenderer, getMessage(), x + halfwidth2, y + (this.height - 8) / 2, textColor);
    }
  }
}