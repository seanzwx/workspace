package com.sean.im.client.custom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CheckCode extends JLabel
{
	private static final long serialVersionUID = 1L;
	private String code;

	public CheckCode()
	{
		this.setIcon(new ImageIcon(this.getImage()));
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				setIcon(new ImageIcon(getImage()));
			}
		});
	}

	public boolean check(String input)
	{
		return code.equals(input);
	}

	private BufferedImage getImage()
	{
		// 验证码图片的宽度。
		int width = 70;
		// 验证码图片的高度。
		int height = 36;
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();

		// 创建一个随机数生成器类。
		Random random = new Random();

		// 设定图像背景色(因为是做背景，所以偏淡)
		g.setColor(getRandColor(180, 250));
		g.fillRect(0, 0, width, height);
		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Times New Roman", Font.PLAIN, 28);
		// 设置字体。
		g.setFont(font);

		// 画边框。
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		// 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。
		g.setColor(Color.GRAY);
		for (int i = 0; i < 50; i++)
		{
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();

		// 设置默认生成4个验证码
		int length = 4;
		// 设置备选验证码:包括"a-z"和数字"0-9"
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";

		int size = base.length();

		// 随机产生4位数字的验证码。
		for (int i = 0; i < length; i++)
		{
			// 得到随机产生的验证码数字。
			int start = random.nextInt(size);
			String strRand = base.substring(start, start + 1);

			// 用随机产生的颜色将验证码绘制到图像中。
			// g.setColor(new Color(red,green,blue));
			// 生成随机颜色(因为是做前景，所以偏深)
			g.setColor(getRandColor(1, 100));
			g.drawString(strRand, 13 * i + 6, 28);

			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}

		this.code = randomCode.toString();
		return buffImg;
	}

	private Color getRandColor(int fc, int bc)
	{// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
