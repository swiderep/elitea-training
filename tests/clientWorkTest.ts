import { test, expect } from '@playwright/test';

test('Client Work Test', async ({ page }) => {
    await page.goto('https://www.epam.com/');
    await page.getByText('Services').click();
    await page.getByRole('link', { name: 'Learn More' }).click();
    const clientWorkTextVisible = await page.getByText('Client Work').isVisible();
    expect(clientWorkTextVisible).toBe(true);
});