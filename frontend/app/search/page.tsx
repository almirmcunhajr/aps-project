import Pagination from '@components/Pagination';
import Card from '@components/Card';

import { SearchBar } from '@components';
import api from '@config/api';
import { ContentType } from '@types';

const SearchPage = async ({ searchParams }: { searchParams: { page: string, query: string}}) => {
  const { page, query } = searchParams;
  const contents = await api({link: `search?query=${query}&page=${page}`});

  return (
    <div className='min-h-screen flex-1 flex-row flex justify-center items-center'>
      <div className='flex-1 flex-col flex justify-start items-center pt-36 sm:px-16 px-6 max-w-[1440px]'>
        <>
          <SearchBar
            text={searchParams.query}
          />
          {contents.length > 0 && (
            <Pagination
              page={searchParams.page}
              query={searchParams.query}
              showNextPage={contents?.length > 0}
            />
          )}
          {contents.length > 0 ? (contents.map((item: ContentType) => {
            return (
              <Card key={item.extId}
                extId={`${item.extId}`}
                language={item.language}
                overview={item.overview}
                title={item.title}
                type={item.type}
              />
            )
          })) : (
            <>Não tem resultados para sua busca!</>
          )}
          <Pagination
            page={searchParams.page}
            query={searchParams.query}
            showNextPage={contents?.length > 0}
          />
        </>
      </div>
    </div>
  )
}

export default SearchPage;