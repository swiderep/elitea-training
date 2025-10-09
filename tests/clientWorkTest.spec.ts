import { test, expect } from '@playwright/test';

test('Client Work Test', async ({ page }) => {
    await page.goto('https://www.epam.com/');
    await page.getByRole('link', { name: 'Services' }).nth(1).click();
    await page.getByRole('link', { name: 'Explore Our Client Work' }).click();
    const isClientWorkVisible = await page.evaluate(() => document.body.innerText.includes('Client Work'));
    expect(isClientWorkVisible).toBe(true);
});
