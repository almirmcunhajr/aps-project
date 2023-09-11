import "./globals.css";

import { Footer, NavBar } from "@components";

export const metadata = {
  title: "Mira",
  description: "Descubra novos conteúdos baseados nas suas preferências",
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang='en'>
      <body className='relative'>
        <NavBar />
        <div id="modal-root"></div>
        {children}
        <Footer />
      </body>
    </html>
  );
}
