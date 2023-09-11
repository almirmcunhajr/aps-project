import { SearchBar, Banner, Content } from "@components";
import api from "@config/api";

//import { banner } from "@constants";
import { ContentType } from "@types";

export default async function HomePage() {
  const content: ContentType[] = await api({link: 'explore?page=1'});

  return (
    <main className='overflow-hidden'>
      {/* <Banner
        content={banner}
      /> */}

      <div className='mt-12 sm:px-16 px-6 py-4 max-w-[1440px] mx-auto'>
        <div className='flex flex-col items-start justify-start pt-36 gap-y-2.5 text-black-100'>
          <h1 className='text-4xl font-extrabold'>Buscador de conteúdo</h1>
          <p>Busque pelo conteúdo desejado</p>
          <SearchBar />
        </div>
      </div>
      
      <div className="mt-12 sm:px-16 px-6 py-4 max-w-[1440px] mx-auto">
        <h1 className='text-4xl font-extrabold'>Catálogo de conteúdo</h1>
        <p>Explore conteúdo que você pode gostar</p>
        <div className="flex flex-row flex-wrap justify-between">
          {content.map((item, index) => {
            return (
              <Content key={index}
                content={item}
              />
            )
          })}
        </div>
      </div>
    </main>
  );
}
